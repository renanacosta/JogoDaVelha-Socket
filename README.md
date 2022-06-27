![Badge](https://img.shields.io/badge/Avaliação_3-Redes_de_Computadores-%237159c1?style=for-the-badge&logo=ghost)

# <p align="center">**Jogo da Velha usando conexão com Sockets**</p>

<p align="center">
<img src="https://user-images.githubusercontent.com/36648528/175844898-eb9884e6-db7a-4224-9d7a-abcb4fab8483.png">
</p>

---
<p align="center">
<img src="https://user-images.githubusercontent.com/36648528/175845369-eb2627dd-0a78-452f-9eed-00ce62019578.gif">
</p>

---

## 🚀 **Instruções para rodar o projeto**
<br>
- Clone o projeto: git clone https://github.com/renanacosta/JogoDaVelha-Socket<br>
- Primeiro inicialize o arquivo Servidor.java; Ele irá pedir para o cliente se conectar ao servidor;<br>
- Depois inicialize o arquivo Cliente1.java. Ele irá se conectar ao servidor, e o servidor continuará aguardando a conexão do Cliente2;<br> 
- Depois inicialize o arquivo Cliente2.java. Ele irá se conectar ao servidor, e o mesmo irá identificar a conexão dos jogadores, inicializando o jogo.<br>

---

## 📖 Sobre o projeto

O projeto foi desenvolvido para avaliação 3 da disciplina de Redes de Computadores, ministrado pelo professor **Luciano Vargas Gonçalves** do curso de Tecnologia em Análise e Desenvolvimento de Sistemas do IFRS, campus Rio Grande.

Tendo como objetivo a implementação um jogo de **Jogo_da_Velha**, utilizando sockets para comunicação entre os dois jogadores.<br>
Foi utilizado a linguagem de programação **Java** para a implementação do jogo.
<br>

## 📖 Instruções

---

<br>
1) Implemente o Jogo da Velha On-line usando Socket;

- a) Implemente um Servidor de Rede que receba duas conexões de rede de dois clientes jogadores) na porta 10000. Após inicie o “jogo da Velha On-line”;

- b) Adiciona um elemento no início da Lista (lista *l , elemento *e). Função sem retorno.
<br><br>
==> O servidor sorteará o jogador, que será o (X) e consequentemente outro jogador será o (O); Esta informação deve ser repassada aos jogadores;<br>
==> Após o jogador(X) visualiza o tabuleiro e pode realizar uma jogada, informando linha e coluna da matriz do jogo (tabuleiro) . O cliente retorna para o servidor as informações da jogada. O servidor valida e confirmar a jogada, após verificar se o jogo terminou: tabuleiro cheio ou se o jogador venceu.<br>
==> Caso o jogador(X) não tenha vencido, o tabuleiro é enviado para jogador(O) realizar uma jogada, esse informa uma nova linha e coluna da matriz do jogo (tabuleiro) . O jogador(O) retorna para o servidor as informações da jogada. O servidor valida e confirmar a jogada, após verificar se o jogo terminou: tabuleiro cheio ou se o jogador venceu.<br>
==> Caso o jogador (O) não tenha vencido o processo se reinicia com o jogador (X) fazendo uma nova jogada;<br>
==> Caso um dos jogadores vença a partida, os dois jogadores deveram ser informados do jogador vencedor, e o estado final do tabuleiro com a jogada final;<br>
==> Em caso de um jogada inválida, novas informações devem ser solicitadas ao jogador;
<br><br>
- c) Após o término da partida, os clientes devem ser consultados para a realização de uma nova partida, caso os jogadores aceitem, uma nova partida inicia, com o sorteio dos jogadores (X,O) e as novas rodadas; Caso contrário, os jogadores serão avisados do fim do jogo e encerram suas conexões com servidor. Este último volta a ficar pronto para uma nova partida (aguardando novas conexões);

- d) O trabalho deverá ser apresentado e entregue no dia 27/06, será necessário realizar a execução de pelo menos uma partida usando a rede do laboratório (servidor e clientes em máquinas diferentes);

<br><br>

---

# 💾 Clone do repositório

<img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white">

git clone https://github.com/renanacosta/JogoDaVelha-Socket

**Desenvolvido por [Renan Gomes Acosta](https://github.com/renanacosta).**
