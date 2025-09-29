public interface Listavel {
	
	//anexa(insere ao final da lista) a lista o novo dado fornecido
	void anexar(Object dado);
	//insere o novo dado fornecido na lista, numa posicao logica informada 
	void inserir(int posicao, Object dado);	
	//retorna o elemento que está numa posicao logica informada
	Object selecionar(int posicao);
	//retorna o elemento que está numa posicao logica informada
	Object[] selecionarTodos();
	//substitui o elemento de uma posicao logica informada,
	//pelo novo elemento fornecido
	void atualizar(int posicao, Object novoDado);	
	//remove o elemento de uma posicao logica informada
	Object apagar(int posicao);
	
	//métodos auxiliares
	boolean estaCheia();
	boolean estaVazia();
	String imprimir();

	
}

// | Estrutura          | Inserção                             | Remoção                              | Acesso direto a qualquer posição?                 |
// | ------------------ | ------------------------------------ | ------------------------------------ | ------------------------------------------------- |
// | **Pilha**          | Sempre no **topo**                   | Sempre no **topo**                   | ❌ Não. Só consegue olhar o topo                   |
// | **Fila**           | Sempre no **fim**                    | Sempre no **início**                 | ❌ Não. Só consegue acessar o da frente            |
// | **Fila dupla**     | Pode ser no **início** ou no **fim** | Pode ser no **início** ou no **fim** | ❌ Não. Só consegue acessar extremidades           |
// | **Fila circular**  | No **fim** (mas circula no array)    | No **início** (mas circula no array) | ❌ Não. Igual à fila, só pelas extremidades        |
// | **Lista circular** | Em **qualquer posição lógica**       | Em **qualquer posição lógica**       | ✅ Sim. Pode acessar posição 0, 5, 10… diretamente |
