package codekata.dependencies;

public class TransitiveDependencyGraphResolver implements DependencyGraphResolver {
	@Override
	public DependencyGraph resolve(DependencyGraph unresolvedGraph) {
		return unresolvedGraph;
	}
}
