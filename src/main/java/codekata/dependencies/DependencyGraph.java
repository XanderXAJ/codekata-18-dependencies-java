package codekata.dependencies;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class DependencyGraph {
	private Map<String, Set<String>> dependencyMap;

	public DependencyGraph(Map<String, Set<String>> dependencyMap) {this.dependencyMap = dependencyMap;}

	public Set<String> dependenciesFor(String dependent) {
		Set<String> dependencies = Collections.emptySet();

		if (dependencyMap.containsKey(dependent)) {
			dependencies = dependencyMap.get(dependent);
		}

		return dependencies;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DependencyGraph that = (DependencyGraph) o;
		return Objects.equals(dependencyMap, that.dependencyMap);
	}

	public Set<String> allDependents() {
		return dependencyMap.keySet();
	}

	@Override
	public int hashCode() {
		return Objects.hash(dependencyMap);
	}

	@Override
	public String toString() {
		return dependencyMap.toString();
	}
}
