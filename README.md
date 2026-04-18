# ⚽ Time Demo API

API REST para gerenciamento de equipes e jogadores, desenvolvida com Spring Boot e JPA.

---

## 🛠️ Tecnologias

- Java 25
- Spring Boot
- Spring Data JPA
- Jakarta Persistence
- Banco de dados relacional (H2 / MySQL / PostgreSQL)

---

## 📁 Estrutura do Projeto

```
src/main/java/com/time/demo/
├── controller/
│   ├── EquipeController.java
│   └── JogadorController.java
├── model/
│   ├── Equipe.java
│   └── Jogador.java
├── dto/
│   ├── EquipeDTO.java
│   └── JogadorDTO.java
├── repository/
│   ├── EquipeRepository.java
│   └── JogadorRepository.java
└── DemoApplication.java
```

---

## 🚀 Como rodar

```bash
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

---

## 📌 Endpoints

### Equipe

|Método|Rota|Descrição|
|---|---|---|
|POST|`/time/criar`|Cria uma nova equipe|
|GET|`/time/{idEquipe}`|Retorna o tamanho do plantel|
|GET|`/time/plantel/{idEquipe}`|Lista os jogadores do plantel|
|POST|`/time/{idEquipe}/registrar/{idJogador}`|Vincula um jogador a uma equipe|

### Jogador

|Método|Rota|Descrição|
|---|---|---|
|POST|`/jogador/criar`|Cria um novo jogador|
|GET|`/jogador/{idJogador}`|Retorna os dados de um jogador|

---

## 📨 Exemplos de Requisição

### Criar equipe

```http
POST /time/criar
Content-Type: application/json

{
    "nome": "Flamengo"
}
```

### Criar jogador

```http
POST /jogador/criar
Content-Type: application/json

{
    "nome": "Ronaldo",
    "idade": 25,
    "altura": 183
}
```

### Vincular jogador a uma equipe

```http
POST /time/1/registrar/1
```

---

## 🔗 Relacionamentos

- Uma **Equipe** pode ter vários **Jogadores** (`@OneToMany`)
- Um **Jogador** pertence a uma **Equipe** (`@ManyToOne`)