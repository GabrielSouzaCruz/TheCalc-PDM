# TheCalc PDM 📱🧮

Projeto de uma calculadora funcional para dispositivos Android, desenvolvida como requisito académico para a disciplina de Programação de Dispositivos Móveis (PDM) do curso de Sistemas de Informação no IF Sul de Minas - Campus Machado.

## 🚀 Funcionalidades

* **Operações Básicas:** Soma (+), Subtração (-), Multiplicação (*) e Divisão (/).
* **Percentagem (%):** Cálculo direto de percentagens integrado nas expressões.
* **Operações em Sequência:** O resultado de uma expressão é automaticamente utilizado como entrada para a operação seguinte, permitindo cálculos contínuos.
* **Botão Reset (C):** Limpa o ecrã, o histórico da última expressão e a memória da calculadora.
* **Botão Delete (D):** Apaga o último carácter introduzido. Possui uma trava de segurança de usabilidade: se pressionado logo após um cálculo ser finalizado, limpa o ecrã para proteger o resultado, em vez de apagar os números dígito a dígito.
* **Interface Moderna:** Esquema de cores "Night Mode" (Modo Escuro) com destaques em tons de laranja para facilitar a leitura e reduzir o cansaço visual.

## 🛠️ Tecnologias e Bibliotecas Utilizadas

* **Linguagem:** Java (Android SDK)
* **Interface:** XML
* **Biblioteca Externa:** [exp4j](https://www.objecthunter.net/exp4j/) (v0.3.11) - Utilizada para a avaliação e resolução rápida de expressões matemáticas em formato de texto.

## 🧠 Destaques da Implementação (Arquitetura e Lógica)

O código foi estruturado com foco na eficiência, reutilização e na experiência do utilizador (IHC):

1. **Reutilização de Código:** Em vez de instanciar eventos de clique individuais para cada botão numérico, foi criado um único `OnClickListener` genérico, aplicando o conceito de DRY (*Don't Repeat Yourself*).
2. **Sanitização de Expressões:** Como a biblioteca `exp4j` interpreta o símbolo `%` como operador de módulo (resto da divisão) e exige formatação americana, o algoritmo realiza a substituição dinâmica de caracteres em tempo de execução (trocando `,` por `.`, `÷` por `/`, e `%` por `/100`).
3. **Gestão de Estado:** Implementação de variáveis de estado (`calculoRealizado`) para que a aplicação compreenda o contexto da interface, distinguindo entre o momento de "introdução de dados" e a "exibição de um resultado final".

## ⚙️ Como Executar o Projeto

1. Faça o clone deste repositório:
   ```bash
   git clone [https://github.com/gabrielsouzacruz/thecalc-pdm.git](https://github.com/gabrielsouzacruz/thecalc-pdm.git)
   ```
2. Abra a pasta do projeto no **Android Studio**.
3. Aguarde a sincronização do Gradle (certifique-se de que o ficheiro `app/libs/exp4j-0.3.11.jar` está corretamente referenciado).
4. Compile e execute a aplicação num Emulador Android ou num dispositivo físico ligado por depuração USB.
