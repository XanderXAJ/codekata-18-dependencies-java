package codekata.dependencies;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TransitiveDependencyGraphResolver implements DependencyGraphResolver {
	@Override
	public DependencyGraph resolve(DependencyGraph unresolvedGraph) {
		Map<String, Set<String>> resolvedDependencies = new HashMap<>();

		for (String dependent : unresolvedGraph.allDependents()) {
			Set<String> allDependencies = new HashSet<>();

			Set<String> directDependencies = unresolvedGraph.dependenciesFor(dependent);
			allDependencies.addAll(directDependencies);

			for (String directDependency : directDependencies) {
				Set<String> indirectDependencies = unresolvedGraph.dependenciesFor(directDependency);
				allDependencies.addAll(indirectDependencies);
			}

			resolvedDependencies.put(dependent, allDependencies);
		}

		return new DependencyGraph(resolvedDependencies);
	}
}
