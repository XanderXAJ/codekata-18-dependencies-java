package codekata.dependencies;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TransitiveDependencyGraphResolverTest {
	TransitiveDependencyGraphResolver resolver = new TransitiveDependencyGraphResolver();

	@Test
	void resolvesNothingAsItself() {
		DependencyGraph graph = new DependencyGraph(Collections.emptyMap());

		assertThat(resolver.resolve(graph)).isEqualTo(graph);
	}
}