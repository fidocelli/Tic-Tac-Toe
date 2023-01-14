    import java.awt.*;
    import java.awt.event.*;
    

    class game extends Frame implements ActionListener{

        
        Frame f = new Frame();
        Button b[][] = new Button[3][3];
        int x = 0;//0 -- O and 1 -- X
        TextField tf ;
        String m[][]= new String[3][3];
        Label lb;
        Button res;
        int move ;
        public static void main (String args[])
        {
            game ob = new game();
            ob.setup();
        }

        
            public   void setup()
    {  
        f.setBackground(Color.cyan);
       Label head = new Label();
       head.setBounds(60,50,330,50);
       head.setText("TIC-TAC-TOE");
       head.setFont(new Font("Tw Cen MT Condensed Extra Bold",Font.BOLD, 20));
       head.setForeground(Color.black);
       f.add(head);

        for(int x= 0;x<3;x++)
        for(int y =0;y<3;y++)
        b[x][y] = new Button();
       b[0][0].setBounds(60,100,50,50);
       b[0][1].setBounds(110,100,50,50);
       b[0][2].setBounds(160,100,50,50);
       b[1][0].setBounds(60,150,50,50);
       b[2][0].setBounds(60,200,50,50);
       b[1][1].setBounds(110,150,50,50);
       b[2][1].setBounds(110,200,50,50);
       b[1][2].setBounds(160,150,50,50);
       b[2][2].setBounds(160,200,50,50);
       for(int i=0; i<3; i++){
        for(int j=0; j<3; j++){
            b[i][j].setBackground(Color.black);
            b[i][j].setForeground(Color.white);
            b[i][j].setFont(new Font("Tw Cen MT Condensed Extra Bold",Font.BOLD, 20));
        }
       }
        tf = new TextField();
        tf.setBounds(270,200,70,20);
        lb = new Label("RESULTS");
        lb.setFont(new Font("Tw Cen MT Condensed Extra Bold",Font.BOLD, 13));
        lb.setBounds(270,150,70,50);
        f.add(lb);
        res = new Button("RESTART");
        res.setBounds(270,100,70,50);
        res.setFont(new Font("Tw Cen MT Condensed Extra Bold",Font.BOLD, 13));
        f.add(res);
        res.addActionListener(this);
       tf.setEditable(false);
        f.add(tf);
       
        f.setSize(500,500);
        f.setLayout(null);
        f.setVisible(true);
        
       f.addWindowListener(new myclass());
        for(int x =0;x<3;x++)
        {
            for(int y =0 ;y<3;y++){
             f.add(b[x][y]);
             b[x][y].addActionListener(this);}
            }
       for(int x =0;x<3;x++)
       for(int y =0;y<3;y++)
       m[x][y]= " ";
       move=0 ;
    }
        
    void display(String[][]ar)
{
    for(int x =0;x<3;x++){
    for(int y =0;y<3;y++)
    System.out.print(ar[x][y]);
    System.out.println();
}}
 void color(int a[][])
 {
     int a1=0,a2=0;
     for(int x =0;x<3;x++){
           for(int y = 0;y<2;y++){
           a1 = a[x][y++];
           a2= a[x][y];}
           b[a1][a2].setBackground(Color.yellow);
           b[a1][a2].setForeground(Color.black);
        }
    }
    public void actionPerformed(ActionEvent e)
    { String ch="x";
       
        int row=0,coloumn=0;
    if(e.getSource()==res)
    {
       
    game.main(null);
}
    for(int x =0 ;x<3;x++){
    for(int y =0 ;y<3;y++)
    if(e.getSource()==b[x][y])
    {
        b[x][y].setLabel(ch);
             move++;
             row= x;
             coloumn =y;
               b[x][y].removeActionListener(this);
            }
           
        }
        final_move ob = new final_move();
           
            m[row][coloumn]=ch;
             int a1= 0,a2=0;
             int comp_choice[]= new int[3];
             int a[][] =check(m);
            if(a[2][2]==1){
                if(ch.equals("o"))
            tf.setText("AI WON");
            else
            tf.setText("YOU WON");
           color(a);
           switchof();
        }
        else
        {
                 
                  if(move==9)
                  {
                  tf.setText("DRAW");
                  switchof();
                }
                  else{move++;
        comp_choice = ob.best_move(m);
        b[comp_choice[0]][comp_choice[1]].setLabel("o");
        b[comp_choice[0]][comp_choice[1]].removeActionListener(this);
        m[comp_choice[0]][comp_choice[1]]="o";
        a=check(m);
        System.out.println(move);
        if(a[2][2]==-1){
            tf.setText("AI"+" WON");
           color(a);
           switchof();
        }
    }
    }
       
         
    }
    void switchof()
    {
        for(int x = 0;x<3;x++)
        {for(int y =0; y<3;y++)
            b[x][y].removeActionListener(this);
        }
    }
  int[][]  check(String m[][])
    {  
       
        int i , j;
        boolean flag =true;
        String ch ="x";
        int count =0 ;
        int a[][]= new int[3][3];
        while(count <=1)
    {
        count++;
        for(i=0;i<3;i++)
        {flag = true;
            for(j = 0 ;j<3;j++)
            if(ch.equals(m[i][j])==false){
            flag = false;
            break;}
            if(flag==true)
            { j--;
                a[0][0]=i;
              a[0][1]= j;
              a[1][0]=i;
              a[1][1]= j-1;
              a[2][0]=i;
              a[2][1]= j-2;
            break;}
        }
        if(flag==false){
           
            for(i=0;i<3;i++)
        { flag =true;
            for(j = 0 ;j<3;j++)
            if(ch.equals(m[j][i])==false){
            flag = false;
            break;}
            if(flag==true){
            j--;
             a[0][0]=j;
              a[0][1]= i;
              a[1][0]=j-1;
              a[1][1]= i;
              a[2][0]=j-2;
              a[2][1]= i;
            break;}
        }
    }
    if(flag==false)
    { flag = true;
        int x;
        for( x =0;x<3;x++)
        {
           if( ch.equals(m[x][x])==false){
           flag= false;
           break;}
        }
       
        if (flag ==true){
            x--;
         a[0][0]=0;
              a[0][1]= 0;
              a[1][0]=1;
              a[1][1]= 1;
              a[2][0]=2;
              a[2][1]= 2;break; }
        }
           if(flag==false)
           {
               flag = true;j= 2;
               int x ;
               for( x =0;x<3;x++)
        {
           if( ch.equals(m[x][j])==false){
           flag= false;
           break;}
           --j;
        }
        if (flag==true){
            j++;
            i--;
            a[0][0]=0;
              a[0][1]= 2;
              a[1][0]=1;
              a[1][1]= 1;
              a[2][0]=2;
              a[2][1]= 0;break; }
       
    }
       
       
        ch="o";
    }
    if(flag==true&& ch.equals("x"))
     a[2][2] =1;
    else if(flag==true&& ch.equals("o"))
    a[2][2]=-1;
    else
    a[2][2]=  0;
   
    return a ;
   
}

        class myclass extends WindowAdapter
    {
        public void windowClosing(WindowEvent e)
        {
        f.dispose();
        }
    }
    }






    class final_move
{ 
   
    void display(String [][]a)
    {
        for(int x =0;x<3;x++){
        for(int y =0;y<3;y++)
        System.out.print(a[x][y]);
        System.out.println();}
        System.out.println("--");
    }
    int  check(String m[][])
    {  
       
        int i , j;
        boolean flag =true;
        String ch ="x";
        int count =0 ;
        while(count <=1)
    {
        count++;
        for(i=0;i<3;i++)
        {flag = true;
            for(j = 0 ;j<3;j++)
            if(ch.equals(m[i][j])==false){
            flag = false;
            break;}
            if(flag==true)
            break;
        }
        if(flag==false){
           
            for(i=0;i<3;i++)
        { flag =true;
            for(j = 0 ;j<3;j++)
            if(ch.equals(m[j][i])==false){
            flag = false;
            break;}
            if(flag==true)
            break;
        }
    }
    if(flag==false)
    { flag = true;
        for(int x =0;x<3;x++)
        {
           if( ch.equals(m[x][x])==false){
           flag= false;
           break;}}
        }
           if(flag==false)
           {
               flag = true;j= 2;
               for(int x =0;x<3;x++)
        {
           if( ch.equals(m[x][j])==false){
           flag= false;
           break;}
           --j;
        }}
        if(flag==true)
        break;
        ch="o";
    }
    if(flag==true&& ch.equals("x"))
    return 1;
    else if(flag==true&& ch.equals("o"))
    return -1;
    else return 0;
}
   
    int[] check(String a ,String [][] aray)
    {
       int best[]= new int[3];
       best[0]=-1;
       best[1]=-1;
       int win =0;
       if(a.equals("x"))
       win = 1;
       else win =-1;
       for(int x =0 ;x<3;x++)
       {
           for(int y =0;y<3;y++)
           {
               if(aray[x][y].equals(" ")||aray[x][y].equals(" "))
               { aray[x][y] = a;
                   if(check(aray)==win){
                   best[0]=x;
                   best[1]=y;
                   best[2]= win;
                   return best; }
                   else {
                       aray[x][y]=" ";
                    }
                   
                }

            }
        }
        return best;
    }
    boolean empty(String a[][])
    {
        boolean flag = false;
        for(int x =0;x<3;x++){
        for(int y =0;y<3;y++)
        if(a[x][y].equals(" ")||a[x][y].equals(""))
        flag = true;
        }
        return flag;
    }
    int [] best_move(String board[][])
    {
        int move[] = new int [3];
        int best = 100;
        String temp [][] = new String [3][3];
        for(int x =0;x<3;x++){
        for(int y =0;y<3;y++)
          temp[x][y]=board[x][y];}
          int move_val;
          int depth;
          int check[] = check ("o",board);
          if(check[2]==-1)
          return check;
          else
          { check = check("x",board);
              if(check[1]>=0)
              return check;
            }
         
        for(int x =0;x<3;x++)
        {
            for(int y = 0;y<3;y++)
            {
               
                if(temp[x][y].equals(" ")||temp[x][y].equals(""))
                {
                  temp [x][y] = "o";
                  move_val = minimax(temp,0,"x");
                 
                  if(move_val<best)
                  {
                      move[0] = x;
                      move[1] = y;
                      best=  move_val;
                }
                for(int m =0;m<3;m++){
                           for(int n =0;n<3;n++)
                       temp[m][n]=board[m][n];}
                       
            }
        }
    }
        return move;
    }
    int minimax(String aray[][], int depth , String a)
    { String  temp[][]=new  String [3][3];
        for(int x =0;x<3;x++){
        for(int y =0;y<3;y++)
          temp[x][y]=aray[x][y];}
          String opp ;
          if(a.equals("x"))
         
              opp ="o";
            else
            opp ="x";
           
            int res = check(temp);
            if(res!=0)
            {
                if(res==1)
                return res;
                else
                return res;
               
            }else if(res==0&&empty(temp)==false)
            return res;
           
       int best ;
            if(a.equals("x")==true)
            { best=-1;
                for(int x =0;x<3;x++)
                {
                    for(int y=0 ;y<3;y++)
                    {
                        if(aray[x][y].equals(" ")||aray[x][y].equals(""))
                       {
                           aray[x][y] =a;
                           best = Math.max(best,minimax (aray,depth++,opp));
                           for(int m =0;m<3;m++){
                           for(int n =0;n<3;n++)
                       aray[m][n]=temp[m][n];}
                        }
                    }
               }
               return best;
            }
            else{
                best =1;
                for(int x =0;x<3;x++)
                {
                    for(int y=0 ;y<3;y++)
                    {
                        if(aray[x][y].equals(" ")||aray[x][y].equals(""))
                       {
                           aray[x][y] =a;
                           best = Math.min(best,minimax(aray,depth++,opp));
                           for(int m =0;m<3;m++){
                           for(int n =0;n<3;n++)
                       aray[m][n]=temp[m][n];}
                        }
                    }
               }
               return best;
            }
       
    }
    
}
