package org.example;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DocumentManager documentManager = new DocumentManager();

        DocumentManager.Document doc1 = DocumentManager.Document.builder()
                .id("1")
                .title("Java Basics")
                .content("Learn the basics of Java programming.")
                .author(DocumentManager.Author.builder().id("a1").name("John Doe").build())
                .created(Instant.parse("2023-01-01T10:00:00Z"))
                .build();

        DocumentManager.Document doc2 = DocumentManager.Document.builder()
                .id("2")
                .title("Advanced Java")
                .content("Master advanced Java concepts.")
                .author(DocumentManager.Author.builder().id("a2").name("Jane Smith").build())
                .created(Instant.parse("2023-06-01T10:00:00Z"))
                .build();

        documentManager.save(doc1);
        documentManager.save(doc2);

        DocumentManager.SearchRequest request = DocumentManager.SearchRequest.builder()
                .titlePrefixes(Arrays.asList("Java"))
                .authorIds(Arrays.asList("a1"))
                .createdFrom(Instant.parse("2022-12-31T00:00:00Z"))
                .build();

        List<DocumentManager.Document> results = documentManager.search(request);

        System.out.println(results);
    }
}