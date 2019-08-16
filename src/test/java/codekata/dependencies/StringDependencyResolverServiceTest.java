package codekata.dependencies;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StringDependencyResolverServiceTest {
	@Mock
	DependencyGraphParser<String> stringDependencyGraphParser;

	@Mock
	DependencyGraphResolver dependencyGraphResolver;

	@Test
	void parsesStringAndResolvesGraph() {
		Map<String, Set<String>> dependencyMap = new HashMap<>();
		dependencyMap.put("A", Collections.singleton("B"));
		DependencyGraph expectedDependencyGraph = new DependencyGraph(dependencyMap);

		when(stringDependencyGraphParser.parse(any())).thenReturn(expectedDependencyGraph);

		StringDependencyResolverService service = new StringDependencyResolverService(stringDependencyGraphParser, dependencyGraphResolver);
		service.parseAndResolveGraph("A B");

		verify(stringDependencyGraphParser).parse("A B");
		verify(dependencyGraphResolver).resolve(expectedDependencyGraph);
	}
}