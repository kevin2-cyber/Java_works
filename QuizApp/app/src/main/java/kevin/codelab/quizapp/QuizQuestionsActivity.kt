package kevin.codelab.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kevin.codelab.quizapp.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuizQuestionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityQuizQuestionsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val questionsList = Constants.getQuestions()
        Log.i("Question size is ", "${questionsList.size}")

        for (i in questionsList) {
            Log.e("Questions", i.questions)
        }

        var currentPosition = 1
        val question: Question = questionsList[currentPosition - 1]
        binding.progressBar.progress = currentPosition
        binding.ivImage.setImageResource(question.image)
        binding.tvProgress.text = "$currentPosition/${binding.progressBar.max}"
        binding.tvQuestion.text = question.questions
        binding.tvOptionOne.text = question.optionOne
        binding.tvOptionTwo.text = question.optionTwo
        binding.tvOptionThree.text = question.optionThree
        binding.tvOptionFour.text = question.optionFour
    }
}