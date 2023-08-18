package cl.awakelab.sprintfinalm6.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import cl.awakelab.sprintfinalm6.databinding.FragmentDetailPhoneBinding
import coil.load


const val ARG_PARAM_ID = "phoneId"

class PhoneDetailFragment : Fragment() {

    lateinit var binding: FragmentDetailPhoneBinding
    private val phoneViewModel: PhoneViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailPhoneBinding.inflate(inflater, container, false)
        val phoneId = arguments?.getInt("id")?: 0
        phoneViewModel.getPhoneDetail(phoneId)
        phoneViewModel.phoneDetailLiveData(phoneId).observe(viewLifecycleOwner, Observer { detailPhone ->
            if (detailPhone != null) {
                binding.tvIDDetail.text = detailPhone.id.toString()
                binding.imageViewItemDetail.load(detailPhone.image)
                binding.tvNameDetail.text = detailPhone.name
                binding.tvPriceDetail.text = detailPhone.price.toString()
                binding.tvDescriptionDetail.text = detailPhone.description
                binding.tvLastPriceDetail.text = detailPhone.lastPrice.toString()
                if(!detailPhone.credit){
                    binding.tvCreditDetail.text = "Sólo pago en efectivo"
                }else{
                    binding.tvCreditDetail.text = "Se acepta tarjeta de crédito"
                }
            }
        })
        binding.btnContact.setOnClickListener{
            val contact = "info@novaera.cl"
            val emailIntent = Intent(Intent.ACTION_SENDTO)
            val emailText = "Hola: \n Vi este telefono y me gustaría que me contactaran a este \n correo o al siguiente número +56984682043"
            binding.etMessage.setText(emailText)

            emailIntent.type = "text/plain"
            emailIntent.data = Uri.parse("mailto")
            emailIntent.putExtra(Intent.EXTRA_EMAIL, contact)
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Asunto del correo")
            emailIntent.putExtra(Intent.EXTRA_TEXT, binding.etMessage.text)

            startActivity(Intent.createChooser(emailIntent, "Consultar por producto..."))
        }
        return binding.root
    }


}