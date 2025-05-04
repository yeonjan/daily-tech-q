import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;







public class Main {
    private static final List<String> SUBJECTS = List.of("java", "spring", "network", "os", "db", "data_Structure", "algorithm");
    private static final String QUESTION_FILE_PREFIX = "questions_";
    private static final String QUESTION_FILE_SUFFIX = ".txt";
    private static final String SEPARATOR_LINE = "***************************************";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("오늘의 주제는?");
        for (int i = 0; i < SUBJECTS.size(); i++) {
            System.out.println(i + ". " + SUBJECTS.get(i));
        }
        String todaySubject = null;
        while (todaySubject == null) {
            System.out.print("입력: ");
            String input = br.readLine();
            todaySubject = getTodaySubject(input);
        }

        System.out.println(SEPARATOR_LINE);
        System.out.println(getTodayQuestion(todaySubject));
        System.out.println(SEPARATOR_LINE);

    }

    public static String getTodaySubject(String input) {
        try {
            int selectionNum = Integer.parseInt(input);
            if (selectionNum < 0 || selectionNum >= SUBJECTS.size()) {
                System.out.println("리스트에 있는 번호를 입력해주세요.");
                return null;
            }
            return SUBJECTS.get(selectionNum);
        } catch (NumberFormatException e) {
            System.out.println("보기에 있는 숫자를 입력해주세요");
            return null;
        }
    }

    public static String getTodayQuestion(String subject) throws IOException {
        List<String> questions = Files.readAllLines(Paths.get(QUESTION_FILE_PREFIX + subject + QUESTION_FILE_SUFFIX));
        if (questions.isEmpty()) {
            return "질문 파일이 비어 있습니다.";
        }
        Collections.shuffle(questions);
        return questions.getFirst();
    }
}