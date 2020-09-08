import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mftandroidproject.Contact;
import com.example.mftandroidproject.R;

import java.util.ArrayList;

public class contactAdapter extends RecyclerView.Adapter<contactAdapter.ViewHolder> {
    ArrayList<Contact> contacts;
    public contactAdapter(ArrayList<Contact> contacts){
        this.contacts=contacts;


    }

    class ViewHolder extends RecyclerView.ViewHolder {
        EditText fname,lname,phone,email;
        Button button1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.fname=itemView.findViewById(R.id.fname);
            this.lname=itemView.findViewById(R.id.lname);
            this.phone=itemView.findViewById(R.id.phone);
            this.email=itemView.findViewById(R.id.email);
            this.button1=itemView.findViewById(R.id.button1);

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view= layoutInflater.inflate(R.layout.item,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.email.setText(this.contacts.get(position).getEmail());
        holder.fname.setText(this.contacts.get(position).getFirst_name());
        holder.lname.setText(this.contacts.get(position).getLast_name());
        holder.phone.setText(this.contacts.get(position).getMobile());

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
