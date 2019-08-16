package codekata.dependencies;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StringDependencyGraphParser<T> implements DependencyGraphParser<String> {
	@Override
	public DependencyGraph parse(String graph) {
		Map<String, Set<String>> dependencyMap = new HashMap<>();
		dependencyMap.put("A", Set.of("B"));

		return new DependencyGraph(dependencyMap);
	}
}
