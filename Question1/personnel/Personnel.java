package personnel;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.stream.Collectors;
public class Personnel {

	public static ArrayList<Person> readPersonnel(String filename) throws IOException {
		ArrayList<Person> personnelList = new ArrayList<>();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String line = null;
		File file = new File(filename);
		if (!file.exists()) {
			throw new IOException("The file " + filename + " does not exist.");
		}
		if (file.length() == 0) {
			throw new IOException("The file " + filename + " is empty.");
		}
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			while ((line = br.readLine()) != null) {
				if (line.trim().isEmpty()) {  // 检查空行
					continue;  // 跳过空行
				}
				String[] data = line.split(",");
				if (data.length < 4) {  // 基本的Person数据检查
					throw new IOException("Incomplete basic data for Person on line: " + line);
				}
				int id = Integer.parseInt(data[1]);
				String name = data[2];
				Date birthdate = formatter.parse(data[3]);

				switch (data[0]) {
					case "UndergraduateStudent":
						if (data.length < 6) {
							throw new IOException("Incomplete data for UndergraduateStudent on line: " + line);
						}
						String department = data[4];
						int year = Integer.parseInt(data[5]);
						personnelList.add(new UndergraduateStudent(id, name, birthdate, department, year));
						break;
					case "GraduateStudent":
						if (data.length < 6) {
							throw new IOException("Incomplete data for GraduateStudent on line: " + line);
						}
						department = data[4];
						boolean phDStudent = Boolean.parseBoolean(data[5]);
						personnelList.add(new GraduateStudent(id, name, birthdate, department, phDStudent));
						break;
					case "Faculty":
						if (data.length < 8) {
							throw new IOException("Incomplete data for Faculty on line: " + line);
						}
						double salary = Double.parseDouble(data[4]);
						String title = data[5];
						department = data[6];
						boolean tenured = Boolean.parseBoolean(data[7]);
						personnelList.add(new Faculty(id, name, birthdate, salary, title, department, tenured));
						break;
					case "Staff":
						if (data.length < 7) {
							throw new IOException("Incomplete data for Staff on line: " + line);
						}
						salary = Double.parseDouble(data[4]);
						boolean contractor = Boolean.parseBoolean(data[5]);
						boolean fulltime = Boolean.parseBoolean(data[6]);
						personnelList.add(new Staff(id, name, birthdate, salary, contractor, fulltime));
						break;
					case "Administrator":
						if (data.length < 7) {
							throw new IOException("Incomplete data for Administrator on line: " + line);
						}
						salary = Double.parseDouble(data[4]);
						title = data[5];
						double budget = Double.parseDouble(data[6]);
						personnelList.add(new Administrator(id, name, birthdate, salary, title, budget));
						break;
					case "SpecialStudent":
						if (data.length < 6) {
							throw new IOException("Incomplete data for SpecialStudent on line: " + line);
						}
						department = data[4];
						boolean enrolled = Boolean.parseBoolean(data[5]);
						personnelList.add(new SpecialStudent(id, name, birthdate, department, enrolled));
						break;
					default:
						throw new IllegalArgumentException("Unknown personnel type: " + data[0]);
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new IOException("Error parsing the file. Possibly incomplete data on line: " + line);
		} catch (Exception e) {
			throw new IOException("Error reading the file: " + e.toString());
		}

		return personnelList;
	}

	public static void main(String[] args) {
		try {
			System.out.println("Print the contents for b)");
			ArrayList<Person> personnelList = readPersonnel("personnel.csv");
			for (Person person : personnelList) {
				System.out.println(person.toString());
			}

			personnelList.sort(Comparator.comparing(Person::getName));
			System.out.println("Sorted by Name:");
			personnelList.forEach(System.out::println);

			personnelList.sort(Comparator.comparing(Person::getBirthdate));
			System.out.println("\nSorted by Birthdate:");
			personnelList.forEach(System.out::println);

			ArrayList<Faculty> facultyList = personnelList.stream()
					.filter(person -> person instanceof Faculty)
					.map(person -> (Faculty) person)
					.sorted(Comparator.comparingDouble(Faculty::getSalary))
					.collect(Collectors.toCollection(ArrayList::new));

			System.out.println("\nFaculty sorted by Salary:");
			facultyList.forEach(System.out::println);

		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}
	}
}

