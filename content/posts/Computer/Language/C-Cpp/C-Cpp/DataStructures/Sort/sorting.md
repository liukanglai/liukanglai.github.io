# Shell

- 定N，比较相隔N的数，N逐渐减小，直到1

        for(int k = n/2;k > 0;k /= 2){
            for(int i = k;i <= n;i++){
                for(int j = i-k;j >= 0 && a[j] > a[j+k];j -= k){
                    swap(a[j],a[j+k]);
                }
            }            
        }
        
        
