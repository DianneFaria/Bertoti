https://colab.research.google.com/drive/1ar5SzbioZ09arA9zM4SezXo8EfnzInKI#scrollTo=QTCB-ZrcRUZC

## Projeto de Interação Humano-Computador com Telegram Bot

Este projeto implementa um bot que se conecta ao Telegram para auxiliar na consulta de livros em uma base de dados SQLite. O bot responde a comandos em linguagem natural, utilizando a biblioteca llama_cpp_python para processar solicitações e interagir com o banco de dados.

### 1. Passo a passo de configuração
1. Abra o Telegram e procure pelo chat do BotFather.
2. Envie os comandos:
   - `/start`
   - `/newbot`
3. Escolha um nome e um nome de usuário para o seu bot.
4. O BotFather fornecerá um token. Guarde este token para usar posteriormente.
5. Clique no link fornecido pelo BotFather para iniciar uma conversa com seu novo bot.

### 2. Configuração do Ambiente no Google Colab
1. Abra o Google Colab e crie um novo notebook.
2. Cole cada código separado abaixo em uma célula diferente no Colab.

```
!pip install python-telegram-bot==13.7
```
```
!pip install llama_cpp_python
```
```
! pip install pytelegrambotapi
```
3. Importe as bibliotecas:
```
from llama_cpp import Llama
from llama_cpp.llama_tokenizer import LlamaHFTokenizer
```
4. Configure o banco de dados SQLite:
```
import sqlite3

# Conectar ao banco de dados SQLite
conexao = sqlite3.connect('livraria.db')
c = conexao.cursor()

# Criar tabela de livros se não existir
c.execute('''CREATE TABLE IF NOT EXISTS livros
             (id INTEGER PRIMARY KEY, titulo TEXT)''')

# Inserir dados na tabela se não existirem
livros = [('Dom Quixote',), ('O Pequeno Príncipe',), ('Flores para Algernon',), ('Um Homem Chamado Ove',)]
c.executemany("INSERT INTO livros (titulo) VALUES (?)", livros)

# Commit e fechar a conexão
conexao.commit()
conexao.close()
```

5. Aqui você insere o token que recebeu anteriormente:
```
import sqlite3
import telebot

# Token do bot Telegram
API_TOKEN = 'INSIRA O TOKEN AQUI'


# Função para conectar ao banco de dados
def connect_db():
    return sqlite3.connect('livraria.db')

# Função para buscar os livros disponíveis
def encontrar_livros():
    conn = connect_db()
    c = conn.cursor()
    c.execute('SELECT titulo FROM livros')
    titulos = c.fetchall()
    conn.close()
    return [titulo[0] for titulo in titulos]

# Função para buscar o preço de um livro específico
def preco_livro(titulo):
    conn = connect_db()
    c = conn.cursor()
    c.execute('SELECT preco FROM livros_precos JOIN livros ON livros_precos.titulo_id = livros.id WHERE titulo = ?', (titulo,))
    preco = c.fetchone()
    conn.close()
    print("Preço de", titulo, ":", preco)  # Instrução de depuração
    if preco is not None:
        return preco[0]
    else:
        return None

# Função para adicionar um livro à lista
def add_to_list(livro, livro_lista, preco_lista):
    preco = preco_livro(livro)
    if preco is not None:
        livro_lista.append(livro)
        preco_lista.append(preco)
    else:
        print(f"Preço não encontrado para o livro: {livro}")

# Função para calcular o custo total dos livros na lista
def calcular_custo_total(preco_lista):
    total_cost = sum(preco_lista)
    return total_cost

livros_escolhidos = []  # Lista para armazenar os livros escolhidos
precos_escolhidos = []  # Lista para armazenar os preços dos livros escolhidos

def process_message(message_text):
    encontrar_livro = encontrar_livros()

    if "livros" in message_text.lower():
        response = f"Olá! Temos os seguintes livros disponíveis: {', '.join(encontrar_livro)}. Por favor, informe os livros desejados."
        return response

    elif message_text.lower() in [titulo.lower() for titulo in encontrar_livro]:
        livro_escolhido = message_text.lower()
        livros_escolhidos.append(livro_escolhido)
        response = f"Você adicionou '{livro_escolhido}' à sua lista de pedidos. Se desejar mais algum livro, por favor, me informe. Caso contrário, diga 'finalizar'."
        return response

    elif "finalizar" in message_text.lower():
        if livros_escolhidos:
            response = f"Você selecionou os seguintes livros: {', '.join(livros_escolhidos)}. Um atendente virá em breve para tratar dos pagamentos. Obrigado por escolher nossos livros!"
            return response
        else:
            response = "Você ainda não selecionou nenhum livro. Por favor, mande a palavra 'livros' para que eu te mostre os livros disponíveis."
            return response

    else:
        response = "Desculpe, não entendi. Por favor, mande a palavra 'livros' para que eu te mostre os livros disponíveis ou finalize sua lista com a palavra 'finalizar'."
        return response

# Iniciar o bot Telegram
bot = telebot.TeleBot(API_TOKEN)

# Integrar com o manipulador de mensagens do bot
@bot.message_handler(func=lambda message: True)
def reply_to_message(message):
    response = process_message(message.text)
    if response:
        bot.reply_to(message, response)

# Iniciar polling do bot
bot.polling()
```

### 3. Execução do Projeto
1. Rode uma célula de cada vez no Google Colab.
2. No Telegram, abra o chat com seu bot e envie `/start` para iniciar a interação.
