package codekata.dependencies;

import java.util.*;

public class TransitiveDependencyGraphResolver implements DependencyGraphResolver {
	@Override
	public DependencyGraph resolve(DependencyGraph unresolvedGraph) {
		Map<String, Set<String>> resolvedDependencies = new HashMap<>();

		for (String rootDependent : unresolvedGraph.allDependents()) {
			Set<String> directDependencies = unresolvedGraph.dependenciesFor(rootDependent);

			// Seed resolved dependencies and work queue with direct dependencies
			Set<String> rootDependencies = new HashSet<>(directDependencies);
			Queue<String> dependenciesToResolve = new LinkedList<>(directDependencies);

			while (!dependenciesToResolve.isEmpty()) {
				String subDependent = dependenciesToResolve.poll();
				Set<String> subDependencies = unresolvedGraph.dependenciesFor(subDependent);
				subDependencies.removeAll(rootDependencies); // Remove all processed dependencies
				subDependencies.remove(rootDependent); // A dependent can't be a dependency of itself in this model

				dependenciesToResolve.addAll(subDependencies);

				rootDependencies.addAll(subDependencies);
			}

			resolvedDependencies.put(rootDependent, rootDependencies);
		}

		return new DependencyGraph(resolvedDependencies);
	}
}
