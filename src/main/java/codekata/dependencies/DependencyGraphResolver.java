package codekata.dependencies;

public interface DependencyGraphResolver {
    DependencyGraph resolve(DependencyGraph unresolvedGraph);
}
