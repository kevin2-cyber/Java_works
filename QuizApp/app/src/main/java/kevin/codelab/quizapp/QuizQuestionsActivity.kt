package kevin.codelab.quizapp

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import kevin.codelab.quizapp.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener{
    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOption: Int = 0


    private lateinit var binding: ActivityQuizQuestionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityQuizQuestionsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        mQuestionsList = Constants.getQuestions()

        binding.tvOptionOne.setOnClickListener(this)
        binding.tvOptionTwo.setOnClickListener(this)
        binding.tvOptionThree.setOnClickListener(this)
        binding.tvOptionFour.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)

        setQuestion()
    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {

        val question: Question = mQuestionsList!![mCurrentPosition - 1]
        binding.progressBar.progress = mCurrentPosition
        binding.ivImage.setImageResource(question.image)
        binding.tvProgress.text = "$mCurrentPosition/${binding.progressBar.max}"
        binding.tvQuestion.text = question.questions
        binding.tvOptionOne.text = question.optionOne
        binding.tvOptionTwo.text = question.optionTwo
        binding.tvOptionThree.text = question.optionThree
        binding.tvOptionFour.text = question.optionFour

        if (mCurrentPosition == mQuestionsList!!.size) {
            binding.btnSubmit.text = "FINISH"
        } else {
            binding.btnSubmit.text = "SUBMIT"
        }
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        binding.tvOptionOne.let {
            options.add(0,it)
        }
        binding.tvOptionTwo.let {
            options.add(1,it)
        }
        binding.tvOptionThree.let {
            options.add(2,it)
        }
        binding.tvOptionFour.let {
            options.add(3,it)
        }

        for (option in options) {
            // option.setTextColor(Color.parseColor(R.color.grey.toString()))
            option.setTextColor(Color.parseColor(R.color.red.toString()))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int){
        defaultOptionsView()

        mSelectedOption = selectedOptionNum
        tv.setTextColor(Color.parseColor(R.color.darkGrey.toString()))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.tv_option_one -> {
                binding.tvOptionOne.let {
                    selectedOptionView(it,1)
                }
            }

            R.id.tv_option_two -> {
                binding.tvOptionTwo.let {
                    selectedOptionView(it,2)
                }
            }

            R.id.tv_option_three -> {
                binding.tvOptionThree.let {
                    selectedOptionView(it,3)
                }
            }

            R.id.tv_option_four -> {
                binding.tvOptionFour.let {
                    selectedOptionView(it,4)
                }
            }


            R.id.btn_submit -> {
                //TODO: Implement submit button
            }
        }
    }
}