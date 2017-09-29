package sample.kingja.loadsirbestpractice.model.entiy;

import java.util.List;

/**
 * Description:TODO
 * Create Time:2017/3/30 17:19
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class QuestionDetail {
    private Question question;
    private List<Answer> answers;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
