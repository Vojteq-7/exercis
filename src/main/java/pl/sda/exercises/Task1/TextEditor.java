package pl.sda.exercises.Task1;

public class TextEditor {
    private StringBuilder editor;
    public TextEditor(){
        editor = new StringBuilder();
    }
    public TextEditor(String text) {
        this.editor = new StringBuilder(text);
    }

    public void append(String str){
        editor.append(str);
    }

    public void remove(int start, int end){
        editor.delete(start, end);
    }

    public String getText(){
        return editor.toString();
    }

    public int length(){
        return editor.length();
    }

    public void insert(int start, String text){
        editor.insert(start, text);
    }
}
