# springBoot
Pod::Spec.new do |s|
s.name= "RMTestView"
s.version= "1.0.0"
s.summary= "testView"
s.homepage="https://github.com/raomengchen/RMTestView"
s.license= "MIT"
s.authors= {"raomeng" =>"judy9325@163.com"}
s.platform= :ios, "7.0"
s.source= {:git =>"https://github.com/Laity-Di/springBoot.git", :tag =>s.version}
s.source_files ="RMTestView/*.{h,m}"      #swift可以使用类似这样"Classes/**/*.swift "
s.requires_arc = true
end
