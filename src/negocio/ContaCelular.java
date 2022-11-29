package negocio;


public class ContaCelular {

    private int bitcalls;
    Celular celular;
    private int transferir;
    private int[] servico = new int[5];
    private int consumoTotal;
    private boolean estado;

    public ContaCelular() {
        this.bitcalls = 0;
        this.estado = false;
    }
    
    // saldo bitcalls
    public int getBitcalls() {
        return bitcalls;
    }

    // recarregar bitcalls
    public void setBitcalls(int bitcalls) {
        this.bitcalls += bitcalls;
    }

    // quantos bitcalls foram transferidos no total
    public int getTransferir() {
        return transferir;
    }

    public void setTransferir(int bitcalls, ContaCelular celular) {
        if (getBitcalls() > bitcalls) { // apenas se tiver saldo suficiente
            this.transferir += bitcalls; // adiciona à quantidade de bitcalls transferidos

            setConsumoTotal(bitcalls); // diminui a quantidade total de bitcalls

            celular.setBitcalls(bitcalls); // recarrega os bitcalls no outro celular passado como parâmetro
        }
    }

    // consumo dos serviços disponíveis
    public int[] getServico() {
        return servico;
    }

    public void setServico(int opcao) {
        int bitc = 0;
        switch (opcao) {
            case 1: // chamada local
                bitc = 2;
                if (getBitcalls() > bitc) { // se tiver saldo suficiente
                    setConsumoTotal(bitc); // consome a quantidade de bitcalls correspondente ao serviço
                    this.servico[0] += 1; // aumenta a quantidade de utilização do serviço
                }
                break;
            case 2: // chamada de longa distância DDD dentro do estado
                bitc = 3;
                if (getBitcalls() > bitc) {
                    setConsumoTotal(bitc); // consome a quantidade de bitcalls correspondente ao serviço
                    this.servico[1] += 1; // aumenta a quantidade de utilização do serviço
                }
                break;
            case 3: // chamada de longa distância DDD para fora do estado
                bitc = 5;
                if (getBitcalls() > bitc) {
                    setConsumoTotal(bitc); // consome a quantidade de bitcalls correspondente ao serviço
                    this.servico[2] += 1; // aumenta a quantidade de utilização do serviço
                }
                break;
            case 4: // envio de SMS
                bitc = 1;
                if (getBitcalls() > bitc) {
                    setConsumoTotal(bitc); // consome a quantidade de bitcalls correspondente ao serviço
                    this.servico[3] += 1; // aumenta a quantidade de utilização do serviço
                }
                break;
            case 5: // um dia completo de Internet 4G
                bitc = 5;
                if (getBitcalls() > bitc) {
                    setConsumoTotal(bitc); // consome a quantidade de bitcalls correspondente ao serviço
                    this.servico[4] += 1; // aumenta a quantidade de utilização do serviço
                }
                break;
        }
    }

    // vincula essa classe a um objeto celular da classe Celular
    public Celular getNumero() {
        return celular;
    }

    public void setNumero(Celular celular) {
        this.celular = celular;
    }

    // consumo total de bitcalls pela utilização dos serviços
    public int getConsumoTotal() {
        return consumoTotal;
    }

    private void setConsumoTotal(int consumir) {
        if (getBitcalls() > consumir) { // se tiver saldo suficiente
            this.bitcalls -= consumir;
            this.consumoTotal += consumir;
        }
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
