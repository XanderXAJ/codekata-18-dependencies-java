package codekata.dependencies;

import java.util.*;

public class StringDependencyGraphParser implements DependencyGraphParser<String> {
	@Override
	public DependencyGraph parse(String graph) {
		Map<String, Set<String>> dependencyMap = new HashMap<>();

		for (String dependencyLine : graph.split("\n")) {
			List<String> classes = List.of(dependencyLine.split(" "));
			String dependent = head(classes);
			Set<String> dependencies = Set.copyOf(tail(classes));
			dependencyMap.put(dependent, dependencies);
		}

		return new DependencyGraph(dependencyMap);
	}

	private String head(List<String> classes) {
		return classes.get(0);
	}

	private List<String> tail(List<String> classes) {
		return classes.subList(1, classes.size());
	}
}
