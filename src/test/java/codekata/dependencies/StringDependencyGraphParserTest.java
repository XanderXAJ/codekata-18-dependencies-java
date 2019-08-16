package codekata.dependencies;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class StringDependencyGraphParserTest {
	private StringDependencyGraphParser parser = new StringDependencyGraphParser();

	@Test
	void parsesSingleLineGraphWithSingleDependency() {
		Map<String, Set<String>> expectedDependencyMap = new HashMap<>();
		expectedDependencyMap.put("A", Set.of("B"));
		DependencyGraph expected = new DependencyGraph(expectedDependencyMap);

		DependencyGraph actual = parser.parse("A B");

		assertThat(actual).isEqualTo(expected);
	}

	@Test
	void parsesSingleLineGraphWithMultipleDependencies() {
		Map<String, Set<String>> expectedDependencyMap = new HashMap<>();
		expectedDependencyMap.put("A", Set.of("B", "C"));
		DependencyGraph expected = new DependencyGraph(expectedDependencyMap);

		DependencyGraph actual = parser.parse("A B C");

		assertThat(actual).isEqualTo(expected);
	}
}