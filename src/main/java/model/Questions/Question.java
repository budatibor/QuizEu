package model.Questions;

import java.util.List;


/**
 * This is the Question parent class.
 * It stores all the information needed for a question and also many more.
 * It has 5 child classes extending it so its functionalities are well used many times so
 * theres no need to store it multiple times.
 */
public class Question {

    protected String text;
    protected int idx;
    protected List<String> oportunities;


    /**
     * Retrieves the amount of points this question is worth
     * @return int, point worth of question
     */
    public int getPoint() {
        return point;
    }

    /**
     * sets up the point value of the question
     * @param point value of the question
     */
    public void setPoint(int point) {
        this.point = point;
    }

    protected int point;

    /**
     * Retrieves the formulated question
     * @return String, the question text
     */
    public String getText() {
        return text;
    }

    /**
     * Retrieves at which index is the correct answer to this question
     * @return int, correct answer index
     */
    public int getIdx() {
        return idx;
    }

    /**
     * Retrieves the list of all four opportunities of this question
     * @return List&lt;String&gt;, four choice opportunities of this question
     */
    public List<String> getOportunities() {
        return oportunities;
    }

    /**
     * Setting up which opportunity should be the correct answer
     * @param idx, correct answer index
     */
    public void setIdx(int idx) {
        this.idx = idx;
    }

    /**
     * Adding opportunity to the oportunity list
     * @param oportunity, String, a choice opportunity of the question
     */
    public void addOportunity(String oportunity) {
        oportunities.add(oportunity);
    }

    /**
     * Setting up the text of the question
     * @param text, String, text of the question
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * toString() method of the Question class
     * @return String, all information about the class
     */
    @Override
    public String toString() {
        return "Question{" +
                "text='" + text + '\'' +
                ", idx=" + idx +
                ", oportunities=" + oportunities +
                '}';
    }
}
