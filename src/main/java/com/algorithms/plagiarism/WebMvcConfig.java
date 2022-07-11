package com.algorithms.plagiarism;

import lombok.NonNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.ResourceResolver;
import org.springframework.web.servlet.resource.ResourceResolverChain;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        ResourceResolver resolver = new ReactResourceResolver();
        registry.addResourceHandler("/account")
                .resourceChain(true)
                .addResolver(resolver);

        registry.addResourceHandler("/student/**")
                .resourceChain(true)
                .addResolver(resolver);

        registry.addResourceHandler("/teacher/**")
                .resourceChain(true)
                .addResolver(resolver);
    }

    public static class ReactResourceResolver implements ResourceResolver {
        // root dir of react files
        // example REACT_DIR/index.html
        private static final String REACT_DIR = "/static/";

        // this is directory inside REACT_DIR for react static files
        // example REACT_DIR/REACT_STATIC_DIR/js/
        // example REACT_DIR/REACT_STATIC_DIR/css/
        private static final String REACT_STATIC_DIR = "static";

        private final Resource index = new ClassPathResource(REACT_DIR + "index.html");
        private final List<String> rootStaticFiles = Arrays.asList("favicon.io",
                "asset-manifest.json", "manifest.json", "service-worker.js");

        @Override
        public Resource resolveResource(
                HttpServletRequest request, @NonNull String requestPath,
                @NonNull List<? extends Resource> locations, @NonNull ResourceResolverChain chain) {

            return resolve(requestPath, locations);
        }

        @Override
        public String resolveUrlPath(
                @NonNull String resourcePath, @NonNull List<? extends Resource> locations,
                @NonNull ResourceResolverChain chain) {

            Resource resolvedResource = resolve(resourcePath, locations);
            if (resolvedResource == null) {
                return null;
            }
            try {
                return resolvedResource.getURL().toString();
            } catch (IOException e) {
                return resolvedResource.getFilename();
            }
        }

        private ClassPathResource resolve(
                String requestPath, List<? extends Resource> locations) {

            if (requestPath == null) return null;

            if (rootStaticFiles.contains(requestPath)
                    || requestPath.startsWith(REACT_STATIC_DIR)) {
                return new ClassPathResource(REACT_DIR + requestPath);
            } else
                return (ClassPathResource) index;
        }

    }
}