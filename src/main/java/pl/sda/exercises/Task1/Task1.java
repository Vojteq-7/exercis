package pl.sda.exercises.Task1;

/**
 * <h2>Zadanie 1A</h2>
 * <p>
 * Zdefiniuj interfejs (lub klasę abstrakcyjną) <code>Command</code> z metodą <code>execute()</code>
 * oraz klasy ją implementujące (rozszerzajce), które realizują
 * dwie operacje na obiekcie <code>TextEditor</code>:
 * </p>
 * <ol>
 *     <li>
 *         <code>AppendTextCommand</code> - dołączanie na końcu tekstu edytora dowolnego łańcucha
 *     </li>
 *     <li>
 *         <code>RemoveTextCommand</code> - usuwa tekst od pozycji <code>start</code> do pozycji <code>end</code>
 *     </li>
 * </ul>
 * <p>
 * Przyjmij, że polecenie <code>RemoveTextCommand</code> nie zostanie wykonane jeśli nie ma w edytorze tekstu
 * lub zostały podane niepoprawnie indeksy.
 * W każdej klasie utwórz konstruktory, aby odpowiadały wywołaniom w zakomentowanym kodzie metody <code>main</code>.
 * </p>
 * <h2>Zadanie 1B</h2>
 * <p>
 * Wykonaj zadanie 1A rozszerzając interfejs <code>Command</code> o metodę <code>undo</code>,
 * która pozwala cofać wykonaną operację na edytorze
 * </p>
 * <h2>Zadanie 1C</h2>
 * <p>Samodzielnie zdefiniuj nowe polecenie(-a), które można wykonać przy pomocy metod klasy TextEditor.
 * Dopisz także klasy testowe dla
 * wszystkich klas poleceń, uwzględniając przyopadki testowe jak brak tekstu w edytorze, niepoprawne indeksy itd.</p>
 *
 * <h2>TEST Zadań 1A i 1B</h2>
 * <p>
 * Po zdefiniowaniu klas usuń komentarz i wykonaj program, który powinien wyświetlić  komunikaty 'SUCCESS TASK 1A' lub '1B', jeśli
 * poprawnie zostało wykonane zadanie 1A lub/i 1B.
 * </p>
 */
public class Task1 {
    public static void main(String[] args) {
//        TextEditor editor = new TextEditor("start ");
//        List<Command> commands = new ArrayList<>();
//        commands.add(new AppendTextCommand(editor, "appended text"));
//        commands.add(new RemoveTextCommand(editor, 0, 6));
//        commands.forEach(command -> command.execute());
//        if (editor.getText().equals("appended text")){
//            System.out.println("SUCCESS TASK 1A:)");
//        }
//        for (int i = commands.size() - 1; i > -1; i--){
//            commands.get(i).undo();
//        }
//        if (editor.getText().equals("start ")) {
//            System.out.println("SUCCESS TASK 1B:)");
//        }
    }
}
