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

	@Test
	void resolvesOneStepOfTransitiveDependencies() {
		Map<String, Set<String>> dependencyMap = new HashMap<>();
		dependencyMap.put("A", Set.of("B"));
		dependencyMap.put("B", Set.of("C"));
		DependencyGraph input = new DependencyGraph(dependencyMap);

		DependencyGraph actual = resolver.resolve(input);

		Map<String, Set<String>> expectedMap = new HashMap<>();
		expectedMap.put("A", Set.of("B", "C"));
		expectedMap.put("B", Set.of("C"));
		DependencyGraph expected = new DependencyGraph(expectedMap);

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void resolvesOneStepOfTransitiveDependenciesMultipleTimes() {
		Map<String, Set<String>> dependencyMap = new HashMap<>();
		dependencyMap.put("A", Set.of("B", "D"));
		dependencyMap.put("B", Set.of("C"));
		dependencyMap.put("D", Set.of("E"));
		DependencyGraph input = new DependencyGraph(dependencyMap);

		DependencyGraph actual = resolver.resolve(input);

		Map<String, Set<String>> expectedMap = new HashMap<>();
		expectedMap.put("A", Set.of("B", "C", "D", "E"));
		expectedMap.put("B", Set.of("C"));
		expectedMap.put("D", Set.of("E"));
		DependencyGraph expected = new DependencyGraph(expectedMap);

		assertThat(actual).isEqualTo(expected);
	}
}