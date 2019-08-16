package codekata.dependencies;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TransitiveDependencyGraphResolverTest {
	TransitiveDependencyGraphResolver resolver = new TransitiveDependencyGraphResolver();

	@Test
	void resolvesNothingAsItself() {
		DependencyGraph graph = new DependencyGraph(Collections.emptyMap());

		assertThat(resolver.resolve(graph)).isEqualTo(graph);
	}

	@Test
	void resolvesGraphWithNoTransitiveDependenciesAsItself() {
		Map<String, Set<String>> dependencyMap = new HashMap<>();
		dependencyMap.put("A", Set.of("B"));
		DependencyGraph graph = new DependencyGraph(dependencyMap);

		assertThat(resolver.resolve(graph)).isEqualTo(graph);
	}
}