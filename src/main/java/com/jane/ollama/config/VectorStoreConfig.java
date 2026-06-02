package com.jane.ollama.config;

import io.qdrant.client.QdrantClient;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.ollama.OllamaEmbeddingModel;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.ai.vectorstore.qdrant.QdrantVectorStore;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class VectorStoreConfig {

    @Bean("customVectorStore")
    public VectorStore vectorStore(
            QdrantClient qdrantClient,
            @Qualifier("ollamaEmbeddingModel")
            EmbeddingModel embeddingModel) {

        return QdrantVectorStore.builder(qdrantClient, embeddingModel)
                .collectionName("documents")
                .build();
    }
}
