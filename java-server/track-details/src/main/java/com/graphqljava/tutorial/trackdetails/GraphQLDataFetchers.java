package com.graphqljava.tutorial.trackdetails;

import com.google.common.collect.ImmutableMap;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class GraphQLDataFetchers {
    private static List<Map<String, String>> tracks = Arrays.asList(
        ImmutableMap.<String, String>builder()
                .put("id", "track_01")
                .put("title", "Astro Kitty, Space Explorer")
                .put("authorId", "author_01")
                .put("thumbnail", "https://res.cloudinary.com/dety84pbu/image/upload/v1598465568/nebula_cat_djkt9r.jpg")
                .put("length", "1234")
                .put("modulesCount", "6")
                .build(),
        ImmutableMap.<String, String>builder()
                .put("id", "track_02")
                .put("title", "Astro Kitty, Space Explorer again")
                .put("authorId", "author_02")
                .put("thumbnail", "https://res.cloudinary.com/dety84pbu/image/upload/v1598465568/nebula_cat_djkt9r.jpg")
                .put("length", "4321")
                .put("modulesCount", "6")
                .build(),
        ImmutableMap.<String, String>builder()
                .put("id", "track_03")
                .put("title", "Astro Kitty, Space Explorer part three")
                .put("authorId", "author_03")
                .put("thumbnail", "https://res.cloudinary.com/dety84pbu/image/upload/v1598465568/nebula_cat_djkt9r.jpg")
                .put("length", "2345")
                .put("modulesCount", "6")
                .build()
    );

    private static List<Map<String, String>> authors = Arrays.asList(
            ImmutableMap.of("id", "author_01",
                    "name", "Joanne Rowling",
                    "photo", "https://res.cloudinary.com/dety84pbu/image/upload/v1606816219/kitty-veyron-sm_mctf3c.jpg"),
            ImmutableMap.of("id", "author_02",
                    "name", "Herman Melville",
                    "photo", "https://res.cloudinary.com/dety84pbu/image/upload/v1606816219/kitty-veyron-sm_mctf3c.jpg"),
            ImmutableMap.of("id", "author_03",
                    "name", "Anne Rice",
                    "photo", "https://res.cloudinary.com/dety84pbu/image/upload/v1606816219/kitty-veyron-sm_mctf3c.jpg")
    );

    public DataFetcher getTracksForHomeDataFetcher() {
        return dataFetchingEnvironment -> {
            String trackId = dataFetchingEnvironment.getArgument("id");
            return tracks
                    .stream();
        };
    }

    public DataFetcher getAuthorDataFetcher() {
        return dataFetchingEnvironment -> {
            Map<String, String> track = dataFetchingEnvironment.getSource();
            String authorId = track.get("authorId");
            return authors
                    .stream()
                    .filter(author -> author.get("id").equals(authorId))
                    .findFirst()
                    .orElse(null);
        };
    }
}