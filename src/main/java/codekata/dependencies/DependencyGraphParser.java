package codekata.dependencies;

public interface DependencyGraphParser<T> {
    DependencyGraph parse(T graph);
}
