package codekata.dependencies;

public class StringDependencyResolverService {
	private final DependencyGraphParser<String> stringDependencyGraphParser;
	private final DependencyGraphResolver dependencyGraphResolver;

	public StringDependencyResolverService(DependencyGraphParser<String> stringDependencyGraphParser, DependencyGraphResolver dependencyGraphResolver) {
		this.stringDependencyGraphParser = stringDependencyGraphParser;
		this.dependencyGraphResolver = dependencyGraphResolver;
	}

	public DependencyGraph parseAndResolveGraph(String dependencyGraph) {
		DependencyGraph unresolvedGraph = stringDependencyGraphParser.parse(dependencyGraph);
		return dependencyGraphResolver.resolve(unresolvedGraph);
	}
}
