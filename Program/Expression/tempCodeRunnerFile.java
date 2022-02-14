try {
            ExprParser x = new ExprParser(Input);
            ExprPaser exp = x.parseE();
            StringBuilder expression = new StringBuilder();
            Map<String, Integer> answerarg = new HashMap<String, Integer>();
            exp.prettyPrint(expression);
            int realanswer = exp.eval(answerarg);
            System.out.println(expression + " = " + realanswer);
            return String.valueOf(realanswer);
        } catch (Exception e) {
            e.printStackTrace();
            return "Invalid Input";
        }