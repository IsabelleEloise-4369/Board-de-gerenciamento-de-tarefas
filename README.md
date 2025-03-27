# Board de Gerenciamento de Tarefas

## Descrição
Este projeto tem como objetivo criar um board customizável para o gerenciamento de tarefas. O sistema permite a criação e manipulação de boards com colunas, onde os cards representam as tarefas que podem ser movidas entre as colunas conforme seu progresso.

## Funcionalidades
- Criação de Board: O usuário pode criar um novo board, que será salvo em um banco de dados MySQL.
- Colunas Customizáveis: Cada board contém colunas para organizar os cards, incluindo colunas para tarefas iniciadas, concluídas, canceladas e pendentes.
  
- Manipulação de Cards:
    - Mover cards entre as colunas.
    - Cancelar cards.
    - Bloquear e desbloquear cards.

- Relatórios:
    - Geração de relatórios com o tempo gasto nas colunas.
    - Relatório sobre o status de bloqueio e desbloqueio dos cards.

- Regras de Funcionamento
   - Cada board deve ter pelo menos 3 colunas:
     - Inicial: A coluna onde os cards começam.
     - Final: A coluna onde os cards são concluídos.
     - Cancelamento: A coluna para cards cancelados.
     - Pendentes: Colunas adicionais para tarefas em andamento (opcional).
  - Apenas uma coluna do tipo Inicial, Final e Cancelamento pode existir.
  - Os cards podem ser movidos entre as colunas de acordo com a ordem definida, mas podem ser movidos diretamente para a coluna de cancelamento.
  - Cards Bloqueados não podem ser movidos até serem desbloqueados, com justificativas para bloqueio e desbloqueio.

## Tecnologias
- Banco de Dados: MySQL
- Linguagens: Java (para a implementação do sistema)

