package ProjectC;
class dLL{
    Node head;
    Node tail;


    class Node{
        Node next;
        Node prev;
        char val;
        double num;
        Node(char val){
            this.val=val;
        }
        Node(double num){
            this.num=num;
        }
    }
//    dLL1(double num){
//        Node newNode= new Node(num);
//        head=newNode;
//        tail=newNode;
//    }

    public void append(char val){
        Node newNode=new Node(val);
        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
    }
    public void append(double num){
        Node newNode=new Node(num);
        if(head==null &&tail==null){
            head=newNode;
            tail=newNode;
        }
        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
    }



    public void print(){
        Node temp=head;
        while(temp!=null){
            if(temp.val=='+'||temp.val=='-'||temp.val=='/'||temp.val=='*'){
                System.out.print(temp.val+" ");
            }else{
                System.out.print(temp.num+" ");
            }
            temp=temp.next;
        }
    }



    public void div(){

        Node temp1=head;
        while(temp1.val!='/'){
            temp1=temp1.next;
        }
        if(temp1.val=='/'){

            double result=temp1.prev.num/temp1.next.num;
            System.out.println(result);
            Node s= new Node(result);

            Node x=temp1.prev;
            //Node t1=null;
            if(x.prev==null){
                s=head;
                head.prev=null;
                head.next=temp1.next.next;
                //System.out.println(head.val);  //removed .next
            }else{

                Node t1=temp1.prev.prev;
                System.out.println(head.next.val); //removed .prev
                temp1.prev.prev=null;
                t1.next=s;
                s.prev=t1;
            }

            //Node t2=null;
            if(temp1.next.next!=null){
                Node t2=temp1.next.next;
                temp1.next.next=null;
                t2.prev=s;
                s.next=t2;
            }else{
                tail=s;
                tail.next=null;
            }


//            if(t1!=null) {
//                t1.next = s;
//                temp1.prev.prev = null;
//                s.prev=t1;
//            }else {
//                head=s;
//            }
//
//
//            if(t2!=null) {
//                t2.prev = s;
//                temp1.next.next = null;
//                s.next=t2;
//            }else{
//                tail=s;
//            }

            //t1.next=s;

           // t2.prev=s;

        }


    }
}

class DoubleLikedList {
    public static void main(String[] args) {
        dLL myL=new dLL();
        //myL.append(2);
        //myL.append('+');
        myL.append(4);
        myL.append('/');
        myL.append(2);
        myL.append('-');
        myL.append(1);
        myL.div();

        myL.print();
    }
}