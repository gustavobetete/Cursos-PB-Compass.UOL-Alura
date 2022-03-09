public class TesteSaca {
    public static void main(String[] args) {

        Conta conta = new ContaCorrente(123, 123);

        conta.deposita(200);

        try{
            conta.saca(210);
        }catch(SaldoInsuficienteException ex){
            System.out.println("EX: " + ex.getMessage());
        }

        System.out.println(conta.getSaldo());
    }
}
