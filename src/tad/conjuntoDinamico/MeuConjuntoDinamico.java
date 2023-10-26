package tad.conjuntoDinamico;

public class MeuConjuntoDinamico implements ConjuntoDinamicoIF<Integer>{

	
	private Integer[] meusDados = null;
	private int posInsercao = 0;
	
	@Override
	public void inserir(Integer item) {
		if (posInsercao == 0 || posInsercao == meusDados.length)
			meusDados = aumentarArray();
		meusDados[posInsercao] = item;
		posInsercao++;
		// throw new UnsupportedOperationException("Implementar");
	}
	
	private Integer[] aumentarArray() {
		if (meusDados == null)
			return new Integer[1];
		int novoTamanho = posInsercao*2;
		Integer[] arrayMaior = new Integer[novoTamanho];
		for(int i=0; i<posInsercao; i++)
			arrayMaior[i] = meusDados[i];
		return arrayMaior;
		// criar um array maior (arrayMaior)
			// Qual é a taxa de aumento desse array?
		// copiar os dados de meusDados (array cheio)
		// colar os dados para o novo array (arrayMaior)
		// return null;
	}

	@Override
	public Integer remover(Integer item) {
		if (meusDados == null) // nao inseriu nada ainda
			throw new IllegalStateException();
		for (int i=0; i<posInsercao; i++) {
			if (item.equals(meusDados[i])) { // achou!
				Integer resultado = meusDados[i];
				for (int j=i+1; j<posInsercao; j++) // adianta os itens posteriores
					meusDados[i] = meusDados[j];
				meusDados[posInsercao-1] = null;// remove o ultimo item
				posInsercao--;
				return resultado;
			}
		}
		throw new IllegalArgumentException();
	}

	@Override
	public Integer predecessor(Integer item) {
		if (meusDados == null) // nao inseriu nada ainda
			throw new IllegalStateException();
		if (item.equals(meusDados[0]))
			return null;
		for (int i=1; i<posInsercao; i++) {
			if (item.equals(meusDados[i]))
				return meusDados[i-1];
		}
		throw new IllegalArgumentException();
	}

	@Override
	public Integer sucessor(Integer item) {
		if (meusDados == null) // nao inseriu nada ainda
			throw new IllegalStateException();
		if (item.equals(meusDados[posInsercao-1]))
			return null;
		for (int i=0; i<posInsercao-1; i++) {
			if (item.equals(meusDados[i]))
				return meusDados[i+1];
		}
		throw new IllegalArgumentException();
	}

	@Override
	public int tamanho() {
		return posInsercao;
	}

	@Override
	public Integer buscar(Integer item) {
		if (meusDados != null && posInsercao != 0)
			for (int i=0; i<=posInsercao; i++)
				if (meusDados[i].equals(item))
					return meusDados[i];
		throw new IllegalArgumentException();
	}

	@Override
	public Integer minimum() {
		if (meusDados == null) // nao inseriu nada ainda
			throw new IllegalStateException();
		Integer resultado = meusDados[0];
		for (int i=1; i<meusDados.length; i++)
			if (meusDados[i] < resultado)
				resultado = meusDados[i];
		return resultado;
	}

	@Override
	public Integer maximum() {
		if (meusDados == null) // nao inseriu nada ainda
			throw new IllegalStateException();
		Integer resultado = meusDados[0];
		for (int i=1; i<meusDados.length; i++)
			if (meusDados[i] > resultado)
				resultado = meusDados[i];
		return resultado;
	}

}
