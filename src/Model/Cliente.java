package Model;

public class Cliente {

    protected int id;
    protected String nome;
    protected String cpf;

    public Cliente(int id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf.replaceAll("[^0-9]", "");//caso coloque outros caracteres antes do cpf ele exclui e usa apenas os numeros
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public  String getCpf() {
        return cpf;
    }
    //formatação do cpf
    public String getCpfFormatado() {
        return cpf.substring(0,3) + "." +
                cpf.substring(3,6) + "." +
                cpf.substring(6,9) + "-" +
                cpf.substring(9,11);
    }
}
