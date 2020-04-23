package exception.examples;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Game {
    public void saveGame(){
        try {
            saveProgress();
            saveScore();
            saveStadistics();
        } catch (SaveProgressException ex) {
            System.err.println("Can't save progress" + ex.getMessage());
        } catch (SaveScoreException e) {
            e.printStackTrace();
        } catch (SaveStadisticsException ex) {
            System.err.println("Can't save stadistics" + ex.getMessage());
        }

    }

    private void saveProgress() throws SaveProgressException {

        try(FileWriter  writer = new FileWriter("progress.txt", true)) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

            writer.append("Guardado: ").append(now.format(formatter)).append(System.lineSeparator());
        } catch (IOException e) {
            throw new SaveProgressException();
        }
    }

    private void saveScore() throws SaveScoreException {

        try(FileWriter writer = new FileWriter("score.txt", true)) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

            writer.append("Guardado: ").append(now.format(formatter)).append(System.lineSeparator());
            throw new IOException("IOException de prueba");
        } catch (IOException e) {
            throw new SaveScoreException("el mensaje",e);
            }

        }

    private void saveStadistics() throws SaveStadisticsException {

        try(FileWriter writer = new FileWriter("stadistics.txt", true)) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

            writer.append("Guardado: ").append(now.format(formatter)).append(System.lineSeparator());
        } catch (IOException e) {
            throw new SaveStadisticsException();
        }

        }
    }

