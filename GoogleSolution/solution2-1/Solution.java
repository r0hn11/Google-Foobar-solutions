package GoogleQuest;

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static String[] solution(String[] l) {
        List<Integer> major = new ArrayList<Integer>(l.length);
        List<Integer> minor = new ArrayList<Integer>(l.length);
        List<Integer> revision = new ArrayList<Integer>(l.length);

        // splitting values by major, minor and revision
        for(String version : l){
            String[] individual = version.split("\\.");
            if(individual.length==3){
                try{
                    major.add(Integer.parseInt(individual[0]));
                    minor.add(Integer.parseInt(individual[1]));
                    revision.add(Integer.parseInt(individual[2]));
                }catch(Exception ignored){}
            }
            else if(individual.length==2){
                try{
                    major.add(Integer.parseInt(individual[0]));
                    minor.add(Integer.parseInt(individual[1]));
                    revision.add(-1);
                }catch(Exception ignored){}
            }
            else if(individual.length==1){
                try{
                    major.add(Integer.parseInt(individual[0]));
                    minor.add(-1);
                    revision.add(-1);
                }catch(Exception ignored){}
            }
        }

        // sorting
        // we need to move items in corresponding lists if any one is affected
        for(int i=1;i<major.size();i++){
            for(int j=1;j<major.size();j++){
                try{
                    if(major.get(j-1)>major.get(j)){
                        int small_major = major.get(j);
                        int small_minor = minor.get(j);
                        int small_revision = revision.get(j);
                        major.set(j, major.get(j-1));
                        minor.set(j, minor.get(j-1));
                        revision.set(j, revision.get(j-1));
                        major.set(j-1, small_major);
                        minor.set(j-1, small_minor);
                        revision.set(j-1, small_revision);
                    }
                    else if(major.get(j-1)==major.get(j)){
                        if(minor.get(j-1)>minor.get(j)){
                            int small_minor = minor.get(j);
                            int small_revision = revision.get(j);
                            minor.set(j, minor.get(j-1));
                            revision.set(j, revision.get(j-1));
                            minor.set(j-1, small_minor);
                            revision.set(j-1, small_revision);
                        }
                        else if(minor.get(j-1)==minor.get(j)){
                            if(revision.get(j-1)>revision.get(j)){
                                int small_revision = revision.get(j);
                                revision.set(j, revision.get(j-1));
                                revision.set(j-1, small_revision);
                            }
                        }
                    }
                }catch(Exception ignored){}
            }
        }

        // adding values to a new array to create sorted array
        String[] sorted = new String[major.size()];  // since there always be a major number in list, hence valid numbers are added to major list

        for(int i=0;i<sorted.length;i++){
            if(major.get(i)!=-1){
                sorted[i] = Integer.toString(major.get(i));
                if(minor.get(i)!=-1){
                    sorted[i] += "."+minor.get(i);
                    if(revision.get(i)!=-1){
                        sorted[i] += "."+revision.get(i);
                    }
                }
            }
        }

        return sorted;

    }
}