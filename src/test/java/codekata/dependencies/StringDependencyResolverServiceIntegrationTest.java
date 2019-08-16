/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package codekata.dependencies;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;

class StringDependencyResolverServiceIntegrationTest {
    // TODO: Replace with concrete implementation
    @Mock
    DependencyGraphParser<String> stringDependencyGraphParser;

    // TODO: Replace with concrete implementation
    @Mock
    DependencyGraphResolver dependencyGraphResolver;

    @Test
    void testKataExample() {
        String dependencyGraph = "A B C\n" +
                "B C E\n" +
                "C G\n" +
                "D A F\n" +
                "E F\n" +
                "F H";

        StringDependencyResolverService service = new StringDependencyResolverService(stringDependencyGraphParser, dependencyGraphResolver);
        DependencyGraph graph = service.parseAndResolveGraph(dependencyGraph);

        assertThat(graph.dependenciesFor("A")).containsExactlyInAnyOrder("B", "C", "E", "F", "G", "H");
        assertThat(graph.dependenciesFor("B")).containsExactlyInAnyOrder("C", "E", "F", "G", "H");
        assertThat(graph.dependenciesFor("C")).containsExactlyInAnyOrder("G");
        assertThat(graph.dependenciesFor("D")).containsExactlyInAnyOrder("A", "B", "C", "E", "F", "G", "H");
        assertThat(graph.dependenciesFor("E")).containsExactlyInAnyOrder("F", "H");
        assertThat(graph.dependenciesFor("F")).containsExactlyInAnyOrder("H");
    }
}
