public class Match {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;

    public Match(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    public void run() throws InterruptedException {
        if (isCheck()){
            while (this.f1.health>0 && this.f2.health>0){
                System.out.println("==========YENI ROUND==========");
                if (isKick()){
                    this.f2.health = this.f1.hit(this.f2);
                    Thread.sleep(1000);
                } else if (!isKick()) {
                    this.f1.health = this.f2.hit(this.f1);
                    Thread.sleep(1000);
                }
                if (isWin()){
                    break;
                }
                System.out.println(this.f1.name + " 'nin sagligi " + this.f1.health);
                System.out.println(this.f2.name +" 'nin sagligi " + this.f2.health);
            }

        }else {
            System.out.println("sikletler uyumsuz");
        }
    }
    boolean isWin(){
        if (this.f1.health==0){
            System.out.println(this.f2.name + " kazandı");
            return true;
        }
        if (this.f2.health==0){
            System.out.println(this.f1.name + "  kazandı");
            return true;
        }
        return false;
    }
    public boolean isCheck() {
        return ((this.f1.weight>=this.minWeight && this.f1.weight<=this.maxWeight) && (this.f2.weight>=this.minWeight && this.f2.weight<=this.maxWeight));
    }

    boolean isKick(){
        double randomKick = Math.random();
        System.out.println("randomKick: "+randomKick);
        return randomKick > 0.5;
    }
}
