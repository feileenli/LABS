package implementation;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Database {

	/* Leave this public for our testing */
	public Map<String, List<String>> courses;

	public Database() {
		courses = new HashMap<String, List<String>>();
	}

	public void add(String student, String course) {
		List<String> list = courses.get(student);

		if (list == null) {
			list = new ArrayList<String>();
		}
		list.add(course);

		courses.put(student, list);

	}

	public void remove(String student, String course) {
		List<String> list = courses.get(student);

		if (list != null) {
			list.remove(course);
		}
	}

	public boolean isAnyoneTaking(String course) {
		Set<String> students = courses.keySet();

		for (String s : students) {
			List<String> courseList = courses.get(s);

			for (String c : courseList) {
				if (c.equals(course)) {
					return true;
				}
			}
		}
		return false;
	}

}
