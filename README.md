# Spring AI

This project demonstrates how to make your Spring Boot application intelligent with the help of **Spring AI** — a powerful framework for integrating LLM-powered capabilities into enterprise applications.

**Chat Model:** `llama3.2:3b`

---

##  Project Overview

Spring AI enables developers to build feature-rich AI-powered applications using Spring Boot. It abstracts interactions with Large Language Models (LLMs) and provides high-level APIs to implement advanced AI features such as conversational chat, retrieval-augmented generation, function calling, embeddings, and more. :contentReference[oaicite:0]{index=0}

---

##  Core Features

### Conversational AI (Chat)

- Integrate chat models and build AI chat services with contextual conversation support.
- Multi-turn conversation management using memory advisors to remember history. 

### Prompt Engineering

- Create prompts with system, user, and assistant roles.
- Use templates and dynamic prompt construction for better quality responses. 

###  Chat Memory

- Support for conversational memory to maintain context over multiple interactions.
- In-memory and persistent memory mechanisms available via advisors. 

###  Function Calling

- Enable tools and business logic execution via AI prompts.
- Let AI models request actions like fetching data or invoking REST APIs.

### Retrieval-Augmented Generation (RAG)

- Use embeddings and vector stores to query large knowledge bases.
- Integrate vector databases (e.g., PGVector, Redis, Qdrant) for semantic search and document retrieval. :contentReference[oaicite:5]{index=5}

### Embeddings & Vector Stores

- Generate numerical embeddings to represent text.
    Use **qdrant** vector database available through Docker.
- Use embeddings for semantic similarity, clustering, and search. :contentReference[oaicite:6]{index=6}

###  Structured Output Mapping

- Convert AI responses into structured Java objects.
- Map outputs directly into POJOs, Lists, or Maps with converters. :contentReference[oaicite:7]{index=7}

### Multi-Provider Model Support

- Spring AI supports major providers like OpenAI, Anthropic, Microsoft, AWS, Google, and Ollama.
---

##  Typical Use Cases

- **AI Chatbots & Assistants**
- **Knowledge Search & Question-Answering**
- **Document-Based Retrieval & Summarization**
- **Tool-Enabled AI Agents**
- **Semantic Search and Recommendations**

---

## ️ Getting Started

### 1. Create Spring Boot Project

Use Spring Initializr and include the relevant Spring AI starters you need (chat, embeddings, vector stores, etc.). :contentReference[oaicite:11]{index=11}

### 2. Add Dependencies

Add the Spring AI dependencies in your `pom.xml`:

```xml
<dependency>
  <groupId>org.springframework.ai</groupId>
  <artifactId>spring-ai-ollama</artifactId>
</dependency>

```
### 3. Add in application.properties:
```bash
spring.at.model.chat=ollama
spring.ai.ollama.chat.options.model=llama3.2:3b
```
---