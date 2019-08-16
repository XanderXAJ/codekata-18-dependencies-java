package codekata.dependencies;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DependencyGraphTest {

	@Test
	void returnsRequestedDependency() {
		Map<String, Set<String>> dependencyMap = new HashMap<>();
		dependencyMap.put("A", Set.of("B"));

		DependencyGraph graph = new DependencyGraph(dependencyMap);

		Set<String> dependenciesOfA = graph.dependenciesFor("A");

		assertThat(dependenciesOfA).containsExactly("B");
	}

	@Test
	void twoGraphsWithTheSameContentAreEqual() {
		Map<String, Set<String>> dependencyMap1 = new HashMap<>();
		dependencyMap1.put("A", Set.of("B"));

		Map<String, Set<String>> dependencyMap2 = new LinkedHashMap<>();
		dependencyMap2.put("A", Set.of("B"));

		DependencyGraph graph1 = new DependencyGraph(dependencyMap1);
		DependencyGraph graph2 = new DependencyGraph(dependencyMap2);

		assertThat(graph1).isEqualTo(graph2);
	}
}