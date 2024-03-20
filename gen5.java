//import static utils.Utilities.writeFile;

//import javax.swing.text.Utilities;

import org.objectweb.asm.*;

import utils.Utilities;

public class gen5{
    public static void main(String[] args){
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program5", null, "java/lang/Object",null);
        
        {
			MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(Opcodes.ALOAD, 0); //load the first local variable: this
			mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V",false);
			mv.visitInsn(Opcodes.RETURN);
			mv.visitMaxs(1,1);
			mv.visitEnd();
		}  

        {
            MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            mv.visitCode();
            mv.visitLdcInsn((String)"My Name is Nick.");
            mv.visitVarInsn(Opcodes.ASTORE, 1);
            mv.visitLdcInsn((String)"My Name is Mark.");
            mv.visitVarInsn(Opcodes.ASTORE, 2);
            mv.visitLdcInsn((String)"My Name is Bob.");
            mv.visitVarInsn(Opcodes.ASTORE, 3);
          
            for(int i = 1; i<4; i++) 
            {
                print(mv, i);
            }

            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();
       
        }
        cw.visitEnd();

        byte[] b = cw.toByteArray();

        Utilities.writeFile(b,"program5.class");
        
        System.out.println("Done!");
    }

    private static void print(MethodVisitor mv, int index) {
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(Opcodes.ALOAD, index);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
    }
}    