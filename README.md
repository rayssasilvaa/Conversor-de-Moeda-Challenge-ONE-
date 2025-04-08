# Conversor de Moedas Challenge ONE - Projeto em Java 💱

Este projeto é um Conversor de Moedas que permite ao usuário realizar conversões em tempo real entre diferentes moedas utilizando uma API pública de taxas de câmbio. A aplicação interage via terminal (console) e apresenta um menu com 6 opções distintas de conversões de moedas.

## ✅ Funcionalidades

- Interface interativa via console;
- 6 opções distintas de conversão de moedas:
  1. Dólar (USD) -> Real (BRL)
  2. Euro (EUR) -> Dólar (USD)
  3. Real (BRL) -> Peso Argentino (ARS)
  4. Libra Esterlina (GBP) -> Euro (EUR)
  5. Iene Japonês (JPY) -> Real (BRL)
  6. Dólar Canadense (CAD) -> Dólar (USD)
- Consumo de API em tempo real (ExchangeRate API);
- Análise e manipulação de resposta JSON;
- Validação de entrada do usuário;
- Conversões com precisão e formatação.

## 🚀 Tecnologias Utilizadas

- Java 17+
- Biblioteca GSON (para manipulação JSON)
- API: [ExchangeRate-API](https://www.exchangerate-api.com)

## 📦 Como Executar

1. Clone este repositório ou baixe o código:
   ```bash
   git clone https://github.com/seuusuario/conversor-moedas-java.git
   ```
2. Importe o projeto em sua IDE Java (Eclipse, IntelliJ, VSCode etc);

3. Certifique-se de ter a biblioteca GSON adicionada ao classpath:
   - Você pode baixar o `.jar` aqui: [https://repo1.maven.org/maven2/com/google/code/gson/gson/](https://repo1.maven.org/maven2/com/google/code/gson/gson/)

4. Execute a classe `Main.java`.

## 📌 Exemplo de Uso

```
==== CONVERSOR DE MOEDAS ====
1. Dólar (USD) -> Real (BRL)
2. Euro (EUR) -> Dólar (USD)
...
Escolha uma opção: 1
Digite o valor a converter: 10,00
Resultado: 10,00 USD = 58,59 BRL
```

Entrega final: **08 de Abril de 2025**

## 👨‍💻 Autor
- Desenvolvido por [Rayssa Silva]
