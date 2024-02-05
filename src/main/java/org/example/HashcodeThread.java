package org.example;

public class HashcodeThread implements Runnable{
    HashSelection hashSelection;
    long currentTimeMillis;
    String arg;
    String alphabet;
    int passwordLength;
    int value;
    int threads;
    HashcodeThread(String alg, long currentTimeMillis, String alphabet, int passwordLength, String arg , int value, int threads){
        this.hashSelection=new HashSelection(alg);
        this.currentTimeMillis=currentTimeMillis;
        this.alphabet=alphabet;
        this.passwordLength=passwordLength;
        this.arg=arg;
        this.value=value;
        this.threads=threads;
    }

    @Override
    public void run() {
        final int alphabetLength = alphabet.length();
        final int fin =(int)Math.pow(alphabetLength, passwordLength);

        for (int i = value; fin > i; i+=threads){
            StringBuilder password = new StringBuilder();

            for (int j = 0; j < passwordLength; j++){
                password.append(alphabet.charAt((i / ((int)Math.pow(alphabetLength,j))) % alphabetLength));
            }

            String str = password.reverse().toString();

            if (arg.equals(hashSelection.calculateHash(str))) {
                System.out.println("Количество потоков для вычислений: " + threads + "\n" +
                        "Пароль: " + str + "\n" +
                        "Хэш пароля: " + arg + "\n" +
                        "Время: " + (double) (System.currentTimeMillis() - currentTimeMillis)/1000);
                System.exit(0);
            }
        }
    }
}
